package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  val quantity: Long,


//  @OneToOne(mappedBy = "inventory", fetch = FetchType.EAGER)
//  val warehouses: Warehouses,

  @OneToOne(mappedBy = "inventory", fetch = FetchType.EAGER)
  val produtoSku: ProdutoSku,

    @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "endereco_id")
  val endereco: Endereco?
  )
//  @JsonManagedReference
//  @OneToMany(mappedBy = "inventory", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//  var produtoSku: List<ProdutoSku> = emptyList(),




//  @JsonManagedReference
//  @OneToMany(mappedBy = "warehouses", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//  var warehouses: List<Warehouse> = emptyList(),

//)

