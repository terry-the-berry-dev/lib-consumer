package com.praynikk.gmail.com.runtime.data;

import com.praynikk.gmail.com.runtime.model.CreatedBook;
import com.praynikk.gmail.com.runtime.model.CreatedBook_;
import com.praynikk.gmail.com.runtime.request.CreatedBookFilter;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreatedBookRepository {

  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  /**
   * @param createdBookFilter Object Used to List CreatedBook
   * @param securityContext
   * @return List of CreatedBook
   */
  public List<CreatedBook> listAllCreatedBooks(
      CreatedBookFilter createdBookFilter, UserSecurityContext securityContext) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<CreatedBook> q = cb.createQuery(CreatedBook.class);
    Root<CreatedBook> r = q.from(CreatedBook.class);
    List<Predicate> preds = new ArrayList<>();
    addCreatedBookPredicate(createdBookFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));

    TypedQuery<CreatedBook> query = em.createQuery(q);

    if (createdBookFilter.getPageSize() != null
        && createdBookFilter.getCurrentPage() != null
        && createdBookFilter.getPageSize() > 0
        && createdBookFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(createdBookFilter.getPageSize() * createdBookFilter.getCurrentPage())
          .setMaxResults(createdBookFilter.getPageSize());
    }
    return query.getResultList();
  }

  public <T extends CreatedBook> void addCreatedBookPredicate(
      CreatedBookFilter createdBookFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    if (createdBookFilter.getTitle() != null && !createdBookFilter.getTitle().isEmpty()) {
      preds.add(r.get(CreatedBook_.title).in(createdBookFilter.getTitle()));
    }

    if (createdBookFilter.getTitleLike() != null && !createdBookFilter.getTitleLike().isEmpty()) {
      preds.add(cb.like(r.get(CreatedBook_.title), createdBookFilter.getTitleLike()));
    }

    if (createdBookFilter.getId() != null && !createdBookFilter.getId().isEmpty()) {
      preds.add(r.get(CreatedBook_.id).in(createdBookFilter.getId()));
    }
  }

  /**
   * @param createdBookFilter Object Used to List CreatedBook
   * @param securityContext
   * @return count of CreatedBook
   */
  public Long countAllCreatedBooks(
      CreatedBookFilter createdBookFilter, UserSecurityContext securityContext) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<CreatedBook> r = q.from(CreatedBook.class);
    List<Predicate> preds = new ArrayList<>();
    addCreatedBookPredicate(createdBookFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends CreatedBook, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(c);
    Root<T> r = q.from(c);
    List<Predicate> preds = new ArrayList<>();
    preds.add(r.get(idField).in(ids));

    q.select(r).where(preds.toArray(new Predicate[0]));
    return em.createQuery(q).getResultList();
  }

  public <T extends CreatedBook, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends CreatedBook, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends CreatedBook, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return listByIds(c, idField, Collections.singleton(id), securityContext).stream()
        .findFirst()
        .orElse(null);
  }

  @Transactional
  public <T> T merge(T base) {
    T updated = em.merge(base);
    applicationEventPublisher.publishEvent(updated);
    return updated;
  }

  @Transactional
  public void massMerge(List<?> toMerge) {
    for (Object o : toMerge) {
      Object updated = em.merge(o);
      applicationEventPublisher.publishEvent(updated);
    }
  }
}
