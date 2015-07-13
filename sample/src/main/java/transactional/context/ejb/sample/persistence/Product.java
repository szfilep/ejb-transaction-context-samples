package transactional.context.ejb.sample.persistence;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 3001627567059124278L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Date creationDate;

	public Product() {
	}

	public Product(String name) {
		this.name = name;
		this.creationDate = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}

}