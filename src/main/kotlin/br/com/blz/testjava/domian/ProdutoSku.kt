package br.com.blz.testjava.domian

import javax.persistence.*

//@Entity
@Table(name = "PRODUTO_SKU")
data class ProdutoSku(

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  val id: Long,
  val sku: Long,
  val name: String,
  val inventory: List<Inventory>,

//  @JsonBackReference
//  @OneToOne(mappedBy = "warehouse", fetch = FetchType.EAGER)
//  val inventory: Inventory
)

