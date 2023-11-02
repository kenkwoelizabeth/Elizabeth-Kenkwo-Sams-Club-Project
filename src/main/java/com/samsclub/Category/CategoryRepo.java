package com.samsclub.Category;

import com.samsclub.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {


}
