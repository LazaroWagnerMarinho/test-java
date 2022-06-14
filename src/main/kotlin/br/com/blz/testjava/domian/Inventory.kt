package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "SKU_INVENTORY")
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val warehouse: String

)

