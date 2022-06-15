//package br.com.blz.testjava.domian
//
//import com.fasterxml.jackson.annotation.JsonBackReference
//import com.fasterxml.jackson.annotation.JsonManagedReference
//import javax.persistence.*
//
//@Entity
//data class Warehouses (
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  val id: Long,
//
//
//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "inventory_id")
//  var inventory: Inventory,
//
//  @JsonBackReference
//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "endereco_id")
//  val endereco: Endereco?
//  )
