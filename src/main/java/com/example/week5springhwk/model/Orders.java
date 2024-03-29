package com.example.week5springhwk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {//주문

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ElementCollection
    private Map<Long, Integer> foodQuantity;

    @ManyToMany
    @JoinTable(
            name = "ORDER_FOOD",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOOD_ID")
    )
    private List<Food> foods = new ArrayList<>();

    @ManyToOne
    private Restaurant restaurant;

    public Orders(Restaurant restaurant){
        this.restaurant = restaurant;
        this.foodQuantity = new HashMap<>();
    }
}
