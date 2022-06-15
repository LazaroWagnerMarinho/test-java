package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Warehouses (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

//  @JsonManagedReference
//  @OneToMany(mappedBy = "warehouses", fetch = FetchType.EAGER)
//  val endereco: List<Endereco>? = emptyList(),


  @JsonManagedReference
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "endereco_id")
  val endereco: List<Endereco>? = emptyList(),

  @JsonBackReference
  @OneToOne(mappedBy = "warehouses", fetch = FetchType.EAGER)
  val inventory: Inventory? = null,
  )
