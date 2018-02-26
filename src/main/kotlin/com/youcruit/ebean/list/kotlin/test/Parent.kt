package com.youcruit.ebean.list.kotlin.test

import io.ebean.annotation.CreatedTimestamp
import io.ebean.annotation.DbArray
import io.ebean.annotation.UpdatedTimestamp
import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version

@Entity
@Table(name = "e_kotlin_parent")
class Parent(
        @Id
        val id: UUID? = null,
        @CreatedTimestamp
        val created: Instant? = null,
        @UpdatedTimestamp
        val updated: Instant? = null,
        @Version
        val version: Long? = null,
        @DbArray
        val parentTypes: Set<ParentType>
)