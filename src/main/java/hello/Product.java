package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private Integer id;
	@Column(name = "p_code")
	private String code;
	@Column(name = "p_desc")
	private String description;
	@Column(name = "p_category")
	private int category;

	protected Product() {
	}

	public Product(String code, String description, int category) {
		this.code = code;
		this.description = description;
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, code='%s', desc='%s, category=%d']", id, code, description, category);
	}
}
