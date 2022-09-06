<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>WelcomePage</title>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

			<script src="https://code.jquery.com/jquery-3.6.0.js"
				integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
			<script type="text/javascript" charset="utf8"
				src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"
				integrity="sha512-bztGAvCE/3+a1Oh0gUro7BHukf6v7zpzrAb3ReWAVrt+bVNNphcl2tDTKCBr5zk7iEDmQ2Bv401fX3jeVXGIcA=="
				crossorigin="anonymous" referrerpolicy="no-referrer"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js"
				integrity="sha512-4WpSQe8XU6Djt8IPJMGD9Xx9KuYsVCEeitZfMhPi8xdYlVA5hzRitm0Nt1g2AZFS136s29Nq4E4NVvouVAVrBw=="
				crossorigin="anonymous" referrerpolicy="no-referrer"></script>

			<script src="../js/app.js"></script>
		</head>

		<body>
			<div class="p-3 bg-dark text-white">
				<span>
					<h4 class="display-5" style="display: inline-flex; ">Voicera</h4> Click To Call
				</span>
				<span style="margin-left: 50rem;" id="importspan">
					<form action="importcsvdata" method="post" style="display: inline;" enctype="multipart/form-data">
						<input class="form-control"
							style="max-width: fit-content;display: inline-flex;padding-top: 2px;padding-bottom: 7px;margin-right: -1rem;"
							type="file" id="fileupload" name="file" multiple required />
						<button type="submit" class="btn btn-sm btn-light" id="importbutton"
							ondblclick="hideImportButton()">
							<img src="../icons/Import.png" alt="ImportIcon" height=25" width="25"> Import
						</button>
						<button type="reset" hidden id="resetButton"></button>
					</form>
					<button class="btn btn-sm btn-light">
						<img src="../icons/Export.png" alt="ExportIcon" height=25" width="25"> Export
					</button>
				</span>
			</div>

			<table class="table table-hover" id="dialerTab">
				<thead class="fw-bold" align="center">
					<td>Name</td>
					<td>Email</td>
					<td>Mobile 1</td>
					<td>Mobile 2</td>
					<td>Zip</td>
					<td>Priority(1-10)</td>
					<td>Status</td>
					<td></td>
				</thead>
				<tbody>
					<c:forEach items="${dataList}" var="list" varStatus="index">
						<tr>
							<td>${list.name}</td>
							<td>${list.email}</td>
							<td>${list.countryCode}${list.mobile1}</td>
							<td>${list.countryCode}${list.mobile2}</td>
							<td>${list.zip}</td>
							<td>${list.priority}</td>
							<td id="${list.mobile1}">${list.status}</td>
							<td>
								<button class="btn btn-sm"
									onclick="callerInfo('${list.name}','${list.email}','${list.mobile1}','${list.mobile2}', '${list.zip}', '${list.priority}', '${list.status}')">
									<img src="../icons/InfoIcon.png" alt="InfoIcon" height=25" width="25">
								</button>
								<button class="btn btn-sm" onclick="dial('${list.countryCode}','${list.mobile1}')">
									<img src="../icons/Dial.png" alt="DialIcon" height="25" width="25">
								</button>
								<button class="btn btn-sm" onclick="hangup('${list.name}')">
									<img src="../icons/CallEnd.png" alt="CallEndIcon" height="25" width="25">
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</body>

		</html>