package br.com.goldtarget.portaltransparencia.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long codigo;
	private String nomeConta;
	private float valor;
	private boolean isPaga;
	private boolean isEnviada;
	private char img;
	private String inseridaPor;
	private Date dataPgto;
	private Date dataVencimento;
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	private String numero_nota;
	private String numero_documento;
	
	
	public String getNumero_nota() {
		return numero_nota;
	}
	public void setNumero_nota(String numero_nota) {
		this.numero_nota = numero_nota;
	}
	public CategoriaTermoColaborativo getCategoriaTermoColaborativo() {
		return categoriaTermoColaborativo;
	}
	public void setCategoriaTermoColaborativo(CategoriaTermoColaborativo categoriaTermoColaborativo) {
		this.categoriaTermoColaborativo = categoriaTermoColaborativo;
	}
	public PrestadorDeServico getPrestadorDeServico() {
		return prestadorDeServico;
	}
	public void setPrestadorDeServico(PrestadorDeServico prestadorDeServico) {
		this.prestadorDeServico = prestadorDeServico;
	}
	public TermoColaborativo getTermoColaborativo() {
		return termoColaborativo;
	}
	public void setTermoColaborativo(TermoColaborativo termoColaborativo) {
		this.termoColaborativo = termoColaborativo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaTermoColaborativo == null) ? 0 : categoriaTermoColaborativo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataPgto == null) ? 0 : dataPgto.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + img;
		result = prime * result + ((inseridaPor == null) ? 0 : inseridaPor.hashCode());
		result = prime * result + (isEnviada ? 1231 : 1237);
		result = prime * result + (isPaga ? 1231 : 1237);
		result = prime * result + ((nomeConta == null) ? 0 : nomeConta.hashCode());
		result = prime * result + ((numero_documento == null) ? 0 : numero_documento.hashCode());
		result = prime * result + ((numero_nota == null) ? 0 : numero_nota.hashCode());
		result = prime * result + ((prestadorDeServico == null) ? 0 : prestadorDeServico.hashCode());
		result = prime * result + ((termoColaborativo == null) ? 0 : termoColaborativo.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (categoriaTermoColaborativo == null) {
			if (other.categoriaTermoColaborativo != null)
				return false;
		} else if (!categoriaTermoColaborativo.equals(other.categoriaTermoColaborativo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataPgto == null) {
			if (other.dataPgto != null)
				return false;
		} else if (!dataPgto.equals(other.dataPgto))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (img != other.img)
			return false;
		if (inseridaPor == null) {
			if (other.inseridaPor != null)
				return false;
		} else if (!inseridaPor.equals(other.inseridaPor))
			return false;
		if (isEnviada != other.isEnviada)
			return false;
		if (isPaga != other.isPaga)
			return false;
		if (nomeConta == null) {
			if (other.nomeConta != null)
				return false;
		} else if (!nomeConta.equals(other.nomeConta))
			return false;
		if (numero_documento == null) {
			if (other.numero_documento != null)
				return false;
		} else if (!numero_documento.equals(other.numero_documento))
			return false;
		if (numero_nota == null) {
			if (other.numero_nota != null)
				return false;
		} else if (!numero_nota.equals(other.numero_nota))
			return false;
		if (prestadorDeServico == null) {
			if (other.prestadorDeServico != null)
				return false;
		} else if (!prestadorDeServico.equals(other.prestadorDeServico))
			return false;
		if (termoColaborativo == null) {
			if (other.termoColaborativo != null)
				return false;
		} else if (!termoColaborativo.equals(other.termoColaborativo))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	@ManyToOne
	@JoinColumn(name="codigo_categoria_termo_colaborativo")
	private CategoriaTermoColaborativo categoriaTermoColaborativo;
	
	@ManyToOne
	@JoinColumn(name="codigo_prestador_de_servico")
	private PrestadorDeServico prestadorDeServico;
	
	@ManyToOne
	@JoinColumn(name="codigo_termo_colaborativo")
	private TermoColaborativo termoColaborativo;	
		
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeConta() {
		return nomeConta;
	}
	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isPaga() {
		return isPaga;
	}
	public void setPaga(boolean isPaga) {
		this.isPaga = isPaga;
	}
	public boolean isEnviada() {
		return isEnviada;
	}
	public void setEnviada(boolean isEnviada) {
		this.isEnviada = isEnviada;
	}
	public char getImg() {
		return img;
	}
	public void setImg(char img) {
		this.img = img;
	}
	public String getInseridaPor() {
		return inseridaPor;
	}
	public void setInseridaPor(String inseridaPor) {
		this.inseridaPor = inseridaPor;
	}
	public Date getDataPgto() {
		return dataPgto;
	}
	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}
	
	
	
	
	
	
}
