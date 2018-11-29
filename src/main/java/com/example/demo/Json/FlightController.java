package com.example.demo.Json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/flights")
public class FlightController {

   @GetMapping("/flight")
   public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<Flight>();

        Flight flight1 = new Flight();
        flight1.setDeparts("2017-04-21 14:34");
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Johnson");
        Ticket ticket1 = new Ticket();
        ticket1.setPassenger(person1);
        ticket1.setPrice("$500.00");
        ArrayList<Ticket> tickets1 = new ArrayList<Ticket>();
        tickets1.add(ticket1);
        flight1.setTickets(tickets1);
        flights.add(flight1);

        Flight flight2 = new Flight();
        flight2.setDeparts("2017-04-21 14:34");
        Person person2 = new Person();
        person2.setFirstName("Jack");
        person2.setLastName("Jackson");
        Ticket ticket2 = new Ticket();
        ticket2.setPassenger(person2);
        ticket2.setPrice("$800.00");
        ArrayList<Ticket> tickets2 = new ArrayList<Ticket>();
        tickets2.add(ticket2);
        flight2.setTickets(tickets2);
        flights.add(flight2);


        return flights;
    }

    public static class Flight{
        private String departs;
        private ArrayList<Ticket> tickets;

        @JsonProperty("Departs")
        public String getDeparts() {
            return departs;
        }

        public void setDeparts(String departs) {
            this.departs = departs;
        }

        @JsonProperty("Tickets")
        public ArrayList<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(ArrayList<Ticket> tickets) {
            this.tickets = tickets;
        }
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @JsonIgnore
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static class Ticket {
        private Person passenger;
        private String price;
        public Person getPassenger() {
            return passenger;
        }

        public void setPassenger(Person passenger) {
            this.passenger = passenger;
        }


        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }


}
