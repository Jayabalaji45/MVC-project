package com.example.MVC_Proj_Crud.Repo;


import com.example.MVC_Proj_Crud.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
}