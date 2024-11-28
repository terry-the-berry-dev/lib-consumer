package com.praynikk.gmail.com.runtime.service;

import com.praynikk.gmail.com.runtime.data.CreatedBookRepository;
import com.praynikk.gmail.com.runtime.model.CreatedBook;
import com.praynikk.gmail.com.runtime.model.CreatedBook_;
import com.praynikk.gmail.com.runtime.request.CreatedBookCreate;
import com.praynikk.gmail.com.runtime.request.CreatedBookFilter;
import com.praynikk.gmail.com.runtime.request.CreatedBookUpdate;
import com.praynikk.gmail.com.runtime.response.PaginationResponse;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CreatedBookService {

  @Autowired private CreatedBookRepository repository;

  /**
   * @param createdBookCreate Object Used to Create CreatedBook
   * @param securityContext
   * @return created CreatedBook
   */
  public CreatedBook createCreatedBook(
      CreatedBookCreate createdBookCreate, UserSecurityContext securityContext) {

    CreatedBook createdBook = createCreatedBookNoMerge(createdBookCreate, securityContext);
    createdBook = this.repository.merge(createdBook);
    return createdBook;
  }

  /**
   * @param createdBookCreate Object Used to Create CreatedBook
   * @param securityContext
   * @return created CreatedBook unmerged
   */
  public CreatedBook createCreatedBookNoMerge(
      CreatedBookCreate createdBookCreate, UserSecurityContext securityContext) {

    CreatedBook createdBook = new CreatedBook();
    createdBook.setId(UUID.randomUUID().toString());

    updateCreatedBookNoMerge(createdBook, createdBookCreate);

    return createdBook;
  }

  /**
   * @param createdBookCreate Object Used to Create CreatedBook
   * @param createdBook
   * @return if createdBook was updated
   */
  public boolean updateCreatedBookNoMerge(
      CreatedBook createdBook, CreatedBookCreate createdBookCreate) {

    boolean update = false;

    if (createdBookCreate.getTitle() != null
        && (!createdBookCreate.getTitle().equals(createdBook.getTitle()))) {
      createdBook.setTitle(createdBookCreate.getTitle());
      update = true;
    }

    return update;
  }

  /**
   * @param createdBookUpdate
   * @param securityContext
   * @return createdBook
   */
  public CreatedBook updateCreatedBook(
      CreatedBookUpdate createdBookUpdate, UserSecurityContext securityContext) {

    CreatedBook createdBook = createdBookUpdate.getCreatedBook();

    if (updateCreatedBookNoMerge(createdBook, createdBookUpdate)) {
      createdBook = this.repository.merge(createdBook);
    }

    return createdBook;
  }

  /**
   * @param createdBookFilter Object Used to List CreatedBook
   * @param securityContext
   * @return PaginationResponse<CreatedBook> containing paging information for CreatedBook
   */
  public PaginationResponse<CreatedBook> getAllCreatedBooks(
      CreatedBookFilter createdBookFilter, UserSecurityContext securityContext) {

    List<CreatedBook> list = listAllCreatedBooks(createdBookFilter, securityContext);
    long count = this.repository.countAllCreatedBooks(createdBookFilter, securityContext);

    return new PaginationResponse<>(list, createdBookFilter.getPageSize(), count);
  }

  /**
   * @param createdBookFilter Object Used to List CreatedBook
   * @param securityContext
   * @return List of CreatedBook
   */
  public List<CreatedBook> listAllCreatedBooks(
      CreatedBookFilter createdBookFilter, UserSecurityContext securityContext) {

    return this.repository.listAllCreatedBooks(createdBookFilter, securityContext);
  }

  public CreatedBook deleteCreatedBook(String id, UserSecurityContext securityContext) {

    CreatedBook createdBook =
        this.repository.getByIdOrNull(CreatedBook.class, CreatedBook_.id, id, securityContext);

    if (createdBook == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CreatedBook not found");
    }

    this.repository.remove(createdBook);

    return createdBook;
  }

  public <T extends CreatedBook, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends CreatedBook, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends CreatedBook, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends CreatedBook, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return repository.listByIds(c, idField, ids);
  }

  public <T> T merge(T base) {
    return this.repository.merge(base);
  }

  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
