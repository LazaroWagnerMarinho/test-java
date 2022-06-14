//package br.com.blz.testjava.services
//
//import br.com.blz.testjava.domian.ProdutoSku
//import br.com.blz.testjava.repository.SkuRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//class SkuService(@Autowired val db: SkuRepository) {
//
//  fun post(produtoSku: ProdutoSku){
//    db.save(produtoSku);
//  }
//
//  fun findAllProdutoSku(): List<ProdutoSku> = db.findAllProdutoSku()
//}
