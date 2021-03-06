package com.j2ee.java.model.dao;

import java.util.List;

import com.j2ee.java.model.dto.ProductComponent;

public interface ProductComponentDAO {
	public ProductComponent getByID(int id);

	public List<ProductComponent> getAllProductComponent();

	public boolean insertProductComponent(ProductComponent ProductComponent);

	public boolean updateProductComponent(ProductComponent ProductComponent);

	public boolean deleteProductComponent(ProductComponent ProductComponent);
}
