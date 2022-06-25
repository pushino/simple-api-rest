/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.unicauca.customers.access;
import co.unicauca.customers.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;

@Default
public class ICustomerRepositoryImplArrays implements ICustomerRepository {

 public static List<Customer> customers;
 public ICustomerRepositoryImplArrays() {
 if (customers == null){
 customers = new ArrayList<>();
 initialize();
 }
 }
 private void initialize() {
        customers.add(new Customer(1, "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Customer(2, "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(3, "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(4, "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(5, "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
 }
 @Override
 public List<Customer> findAll() {
 return customers;
 }
 @Override
 public Customer findById(Integer id) {

 for (Customer prod : customers) {
 if (prod.getId() == id) {
 return prod;
 }
 }
 return null;
 }
 @Override
 public boolean create(Customer newCustomer) {
 Customer prod = this.findById(newCustomer.getId());
 if (prod != null) {
 //Ya existe
 return false;
 }
 customers.add(newCustomer);
 return true;
 }
 @Override
 public boolean update(Customer customer) {
 Customer prod = this.findById(customer.getId());
 if (prod != null) {
 prod.setFisrtName(customer.getFisrtName());
 //prod.setPrice(product.getPrice());
 //hacer con los otros atributos
 return true;
 }
 return false;
 }
 @Override
 public boolean delete(Integer id) {
 int i = 0;
 for (Customer prod : customers) {
 if (prod.getId() == id) {
 customers.remove(i++);
 return true;
 }
 }
 return false;
 }
}