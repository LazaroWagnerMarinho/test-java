package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Warehouses (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

//  val endereco: String,
  @OneToMany(mappedBy = "warehouses", fetch = FetchType.EAGER)
  val endereco: List<Endereco>?,

  @OneToOne(mappedBy = "warehouses", fetch = FetchType.EAGER)
  val inventory: Inventory?,
  )
