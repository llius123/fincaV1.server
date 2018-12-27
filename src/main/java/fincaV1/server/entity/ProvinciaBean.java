package fincaV1.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class ProvinciaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_provincia")
	private int cod_provincia;

	@Column(name = "desc")
	private String desc;

	public int getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(int cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ProvinciaBean [cod_provincia=" + cod_provincia + ", desc=" + desc + "]";
	}

}