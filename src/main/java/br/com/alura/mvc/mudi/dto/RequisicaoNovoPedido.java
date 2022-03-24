package br.com.alura.mvc.mudi.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank //NotBlank.requisicaoNovoPedido.nomeProduto=não pode estar em branco
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	
	@Column(name="DESC", nullable=true, length=1000)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	private Date dataDaEntrega;
	private String valorNegociado;
	
	public Date getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(Date dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public String getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(String valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setDataDaEntrega(dataDaEntrega);
		pedido.setValorNegociado(valorNegociado);
				
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
	
}
