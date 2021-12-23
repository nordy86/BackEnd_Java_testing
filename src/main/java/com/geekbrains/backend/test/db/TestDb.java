package com.geekbrains.backend.test.db;

import com.geekbrains.backend.test.miniMarket.model.Product;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

import java.util.List;

public class TestDb {

    public static void main(String[] args) {
        DbService dbService = new DbService();
        ProductsMapper productsMapper = dbService.getProductsMapper();

        Products product = productsMapper.selectByPrimaryKey(1l);
        System.out.println(product);

        Products forCreate = new Products();
        forCreate.setTitle("Caarrot");
        forCreate.setPrice(99);
        forCreate.setCategoryId(1l);

        productsMapper.insert(forCreate);

        ProductsExample filter = new ProductsExample();

        List<Products> products = productsMapper.selectByExample(filter);
        System.out.println(products);

        filter.createCriteria()
                .andCategoryIdEqualTo(2l);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andPriceBetween(50, 500);

        System.out.println(productsMapper.selectByExample(filter));

        product.setPrice(66);
        productsMapper.updateByPrimaryKey(product);
        System.out.println(product);
    }
}
