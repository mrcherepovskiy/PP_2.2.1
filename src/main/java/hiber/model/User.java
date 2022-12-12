package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car car;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      User that = (User) obj;
      return Objects.equals(firstName, that.firstName)
              && Objects.equals(lastName, that.lastName)
              && Objects.equals(email, that.email);
   }

   @Override
   public int hashCode() {
      return Objects.hash(firstName, lastName, email);
   }

   @Override
   public String toString() {
      return new StringBuilder()
              .append("Id = ")
              .append(getId())
              .append(" ")
              .append("First Name = ")
              .append(getFirstName())
              .append(" ")
              .append("Last Name = ")
              .append(getLastName())
              .append(" ")
              .append("Email = ")
              .append(getEmail())
              .append(" ")
              .append("Car = ")
              .append(getCar())
              .toString();
   }
}