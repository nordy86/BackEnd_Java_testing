package com.geekbrains.backend.test.db;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.CategoriesExample;
import com.geekbrains.db.model.Products;

import java.util.List;

public class Hw_Db {
    public static void main(String[] args) {

        DbService dbService = new DbService();
        CategoriesMapper categoriesMapper = dbService.getCategoriesMapper();
        ProductsMapper productsMapper = dbService.getProductsMapper();

        Categories forCreate = new Categories();

        forCreate.setId(3L);
        forCreate.setTitle("Товары для дома");
        categoriesMapper.insert(forCreate);

        forCreate.setId(4l);
        forCreate.setTitle("бытовая химия");
        categoriesMapper.insert(forCreate);

        forCreate.setId(5l);
        forCreate.setTitle("товары для животных");
        categoriesMapper.insert(forCreate);

        forCreate.setId(6l);
        forCreate.setTitle("автотовары");
        categoriesMapper.insert(forCreate);

        Products forCreateProd = new Products();

        forCreateProd.setTitle("Полотенце");
        forCreateProd.setPrice(54);
        forCreateProd.setCategoryId(3l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Прищепка");
        forCreateProd.setPrice(4);
        forCreateProd.setCategoryId(3l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Салфетки");
        forCreateProd.setPrice(15);
        forCreateProd.setCategoryId(3l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Отвертка");
        forCreateProd.setPrice(30);
        forCreateProd.setCategoryId(3l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Мыло");
        forCreateProd.setPrice(35);
        forCreateProd.setCategoryId(4l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Дихлофос");
        forCreateProd.setPrice(45);
        forCreateProd.setCategoryId(4l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Шампунь");
        forCreateProd.setPrice(55);
        forCreateProd.setCategoryId(4l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Миска");
        forCreateProd.setPrice(43);
        forCreateProd.setCategoryId(5l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Ошейник");
        forCreateProd.setPrice(80);
        forCreateProd.setCategoryId(5l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Наклейка");
        forCreateProd.setPrice(81);
        forCreateProd.setCategoryId(6l);
        productsMapper.insert(forCreateProd);

        forCreateProd.setTitle("Тосол");
        forCreateProd.setPrice(281);
        forCreateProd.setCategoryId(6l);
        productsMapper.insert(forCreateProd);

        CategoriesExample filter = new CategoriesExample();
            filter.createCriteria()
                    .andIdEqualTo(3l);

        List<Categories> categories = categoriesMapper.selectByExample(filter);
        System.out.println(categories);

        filter.clear();
        filter.createCriteria()
                .andIdEqualTo(4l);
        System.out.println(categoriesMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andIdEqualTo(5l);
        System.out.println(categoriesMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andIdEqualTo(6l);
        System.out.println(categoriesMapper.selectByExample(filter));
    }
}
