<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EducaFin - Categorias</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
<!-- Bootstrap JS e dependências -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

 <!-- Incluindo o CSS personalizado -->
<link rel="stylesheet" href="./css/custom.css">

<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container-fluid mt-4">
	<div class="d-flex align-items-center justify-content-between flex-wrap">
		<div>
		<h5>Gerencie suas categorias por aqui.</h5>
		<p>Consulte, cadastre e edite suas categorias para transações.</p>
		</div>
	 
	 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Nova Categoria</button>
	</div>
	
	<!-- Lista de categorias -->
	
	<div class="card mt-4">
	  <div class="card-body">
		  <table class="table table-borderless">
		  <thead>
		    <tr>
		      <th scope="col">Nome da categoria</th>
		      <th scope="col">Descrição</th>
		      <th scope="col">Data de lançamento</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <td>Jacob</td>
		      <td>Thornton</td>
		      <td>@fat</td>
		    </tr>
		    <tr>
		      <td>Larry the Bird</td>
		      <td>@twitter</td>
		      <td>@twitter</td>
		    </tr>
		  </tbody>
		</table>
	  </div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<!-- Modal de cadastro -->
	
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Cadastro de Categoria</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form action="produto" method="post">
	        <input type="hidden" value="cadastrar" name="acao">
	        <div class="form-group">
	            <label for="id-nome">Nome</label>
	            <input type="text" name="nome" id="id-nome" class="form-control">
	        </div>
	        <div class="form-group">
	            <label for="id-valor">Descrição</label>
	            <input type="text" name="valor" id="id-valor" class="form-control">
	        </div>
	        <div class="form-group">
	            <label for="id-quantidade">Data de lançamento</label>
	            <input type="text" name="quantidade" id="id-quantidade" class="form-control">
	        </div>
	    </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        <button type="submit" class="btn btn-primary">Salvar categoria</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</div>
</body>
</html>
