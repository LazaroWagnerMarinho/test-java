package br.com.blz.testjava.repository

import br.com.blz.testjava.domian.ProdutoSku
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SkuRepository: JpaRepository<ProdutoSku, String>
