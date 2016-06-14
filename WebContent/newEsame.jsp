<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	<%@ include file="bootstrap/css/bootstrap.css" %>
	<%@ include file="bootstrap/css/bootstrap-theme.css" %>
	<%@ include file="styleSheets/style.css" %>
</style>
<title>Nuovo Esame</title>
</head>
<body>
	<f:view>
		<div id="header">
			<div class="jumbotron">
				<h1 id="title">Best Clinic</h1>
				<p id="title">Clinica specializzata</p>
				<img id="im_d"
					src="https://lh3.googleusercontent.com/-OvCyHpPzpow/AAAAAAAAAAI/AAAAAAAAABc/CyOcjcfDw44/photo.jpg"
					alt="testo"
					style="position: absolute; right: 75%; bottom: 70%; width: 12%">
				<img id="im_s"
					src="https://lh3.googleusercontent.com/-OvCyHpPzpow/AAAAAAAAAAI/AAAAAAAAABc/CyOcjcfDw44/photo.jpg"
					alt="testo"
					style="position: absolute; left: 75%; bottom: 70%; width: 12%">
			</div>

			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value="/index.html"/>">Clinica
					</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/faces/loginAmministratore.jsp"/>">
							Login Amministratore</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div id="corpo">
			<h2>Creazione Nuovo Esame</h2>
			<h:form>
				<div>
					Tipologia Esame:
					<h:selectOneMenu value="#{esameController.tipologia}"
						converter="#{tipologiaEsameConverter}">
						<f:selectItems value="#{tipologiaEsameController.tipologie}"
							var="tipologia" itemValue="#{tipologia}"
							itemLabel="#{tipologia.nome}" />
					</h:selectOneMenu>
				</div>
				<div>
					Medico:
					<h:inputText id="medico" value="#{esameController.medico}"
						required="true" requiredMessage="Medico Obbligatorio" />
					<h:message for="medico" styleClass="error" />
				</div>
				<div>
					Paziente:
					<h:selectOneMenu value="#{esameController.paziente}"
						converter="#{pazienteConverter}">
						<f:selectItems value="#{pazienteController.pazienti}"
							var="paziente" itemValue="#{paziente}"
							itemLabel="#{paziente.username}" />
					</h:selectOneMenu>
				</div>
			</h:form>
		</div>
	</f:view>
</body>
</html>