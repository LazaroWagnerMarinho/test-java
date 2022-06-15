package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  val quantity: Long,

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouses_id")
  var warehouses: Warehouses?,

//  val warehouses: String,

  @OneToOne(mappedBy = "inventory", fetch = FetchType.EAGER)
  val produtoSku: ProdutoSku?,

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "warehouse_id")
//  val warehouses: Warehouses,
//

//
//  @JsonBackReference
//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "endereco_id")
//  val endereco: Endereco?
  )

//  @JsonManagedReference
//  @OneToMany(mappedBy = "inventory", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//  val produtoSku: List<ProdutoSku> = emptyList(),




//  @JsonManagedReference
//  @OneToMany(mappedBy = "warehouses", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//  var warehouses: List<Warehouse> = emptyList(),

//)

