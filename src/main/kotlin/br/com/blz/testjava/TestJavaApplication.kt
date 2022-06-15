package br.com.blz.testjava;

//import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
import br.com.blz.testjava.domian.Warehouses
import br.com.blz.testjava.repository.*
import br.com.blz.testjava.services.SkuService
//import br.com.blz.testjava.repository.SkuRepository
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@SpringBootApplication
private class TestJavaApplication

  fun main(args: Array<String>) {
    org.springframework.boot.runApplication<TestJavaApplication>(*args)
  }


