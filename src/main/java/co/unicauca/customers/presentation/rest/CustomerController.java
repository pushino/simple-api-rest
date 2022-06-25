/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.customers.presentation.rest;
import co.unicauca.customers.domain.service.CustomerService;
import co.unicauca.customers.domain.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("customers")
public class CustomerController {
 /**
 * Se inyecta la única implementación que hay de CustomerService
 */
 @Inject
 private CustomerService service;
 public CustomerController() {
 }
 /*
 Su uso desde consola mediante client url:
 curl -X GET http://localhost:8080/Simple-API-REST/product-service/products/
 */
 @GET
 @Produces({MediaType.APPLICATION_JSON})
 public List<Customer> findAll() {
 return service.findAll();
 }
 /*
 Su uso desde consola mediante client url:
 curl -X GET http://localhost:8080/Simple-API-REST/productservice/products/1
 */
 @GET
 @Path("{id}")
 @Produces({MediaType.APPLICATION_JSON})
 public Customer findById(@PathParam("id") int id) {
 return service.findById(id);
 }
 /*
 Su uso desde consola mediante client url:
 curl -X POST \
 http://localhost:8080/Simple-API-REST/product-service/products/ \
 -H 'Content-Type: application/json' \
 -d '{
 "id":1,
 "name":"Nevera Lg",
 "price":6700000
 }'
 */
 @POST
 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 public String create(Customer prod) {
 if (service.create(prod)) {
 return "{\"ok\":\"true\", \"mensaje\":\"Customer creado\",\"errores\":\"\"}";
 } else {
 return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el Customer\",\"errores\":\"Id ya existe\"}";
 }
 }
 /*
 Su uso desde consola mediante client url:
 curl -X PUT \
 http://localhost:8080/Simple-API-REST/product-service/products/\
 -H 'Content-Type: application/json' \
 -d '{
 "name":"Nevera Lg REF. JDK3-34-343",
 "price":2450000
 }'
 */
 @PUT
 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 public String update(Customer prod) {
 if (service.update(prod)) {
 return "{\"ok\":\"true\", \"mensaje\":\"Customer modificado\",\"errores\":\"\"}";
 } else {
 return "{\"ok\":\"false\", \"mensaje\":\"No se pudo modificar el Customer\",\"errores\":\"Id no existe\"}";
 }
 }
 /*
 Su uso desde consola mediante client url:
 curl -X DELETE http://localhost:8080/Simple-API-REST/productservice/products/ 
 */
 @DELETE
 @Path("{id}")
 public String remove(@PathParam("id") Integer id) {
 if (service.delete(id)) {
 return "{\"ok\":\"true\", \"mensaje\":\"Customer borrado\",\"errores\":\"\"}";
 } else {
 return "{\"ok\":\"false\", \"mensaje\":\"No se pudo borrar el customer\",\"errores\":\"Id no existe\"}";
 }
 }
}
