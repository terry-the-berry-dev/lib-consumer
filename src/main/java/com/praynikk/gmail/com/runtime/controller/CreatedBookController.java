package com.praynikk.gmail.com.runtime.controller;

import com.praynikk.gmail.com.runtime.model.CreatedBook;
import com.praynikk.gmail.com.runtime.request.CreatedBookCreate;
import com.praynikk.gmail.com.runtime.request.CreatedBookFilter;
import com.praynikk.gmail.com.runtime.request.CreatedBookUpdate;
import com.praynikk.gmail.com.runtime.response.PaginationResponse;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import com.praynikk.gmail.com.runtime.service.CreatedBookService;
import com.praynikk.gmail.com.runtime.validation.Create;
import com.praynikk.gmail.com.runtime.validation.Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("CreatedBook")
@Tag(name = "CreatedBook")
public class CreatedBookController {

  @Autowired private CreatedBookService createdBookService;

  @DeleteMapping("{id}")
  @Operation(summary = "deleteCreatedBook", description = "Deletes CreatedBook")
  public CreatedBook deleteCreatedBook(
      @PathVariable("id") String id, Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return createdBookService.deleteCreatedBook(id, securityContext);
  }

  @PostMapping("getAllCreatedBooks")
  @Operation(summary = "getAllCreatedBooks", description = "lists CreatedBooks")
  public PaginationResponse<CreatedBook> getAllCreatedBooks(
      @Valid @RequestBody CreatedBookFilter createdBookFilter, Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return createdBookService.getAllCreatedBooks(createdBookFilter, securityContext);
  }

  @PutMapping("updateCreatedBook")
  @Operation(summary = "updateCreatedBook", description = "Updates CreatedBook")
  public CreatedBook updateCreatedBook(
      @Validated(Update.class) @RequestBody CreatedBookUpdate createdBookUpdate,
      Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return createdBookService.updateCreatedBook(createdBookUpdate, securityContext);
  }

  @PostMapping("createCreatedBook")
  @Operation(summary = "createCreatedBook", description = "Creates CreatedBook")
  public CreatedBook createCreatedBook(
      @Validated(Create.class) @RequestBody CreatedBookCreate createdBookCreate,
      Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return createdBookService.createCreatedBook(createdBookCreate, securityContext);
  }
}
