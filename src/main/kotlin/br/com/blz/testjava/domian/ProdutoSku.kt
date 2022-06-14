package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "PRODUTO_SKU")
data class ProdutoSku(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val sku: Long,
  val name: String,
  val inventory: Long,

)

