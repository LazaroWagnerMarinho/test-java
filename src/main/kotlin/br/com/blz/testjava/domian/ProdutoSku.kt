package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class ProdutoSku(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val sku: Long,
  val name: String,
  val inventory: Long,

)

