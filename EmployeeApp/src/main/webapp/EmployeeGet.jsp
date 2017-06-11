<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<script type="text/javascript"> 
function Validate()
{
	var name = document.getElementById('FirstName').value;
	var salary = document.getElementById('Salary').value;

	var valid = true;
	                if(name.length<8 )
	                    {
	                        alert("Name should be 8 characters!");
	                        valid = false;
	                    }
	                if(salary<1000 )
                    {
                        alert("Salary Should be greater than 1000!");
                        valid = false;
                    }
return valid; 
}
  </script>

</head>

<body>
	<form action="/EmployeeApp/EmployeeGet" method="get">
		EmployeeId<input type="text" name="employeeId"><br> <input
			type="submit" value="Submit">
	</form>
	<form name="employeeForm" class="form-horizontal"
		action="/EmployeeApp/EmployeeGet" method="Post"
		onsubmit="return Validate()">
		<fieldset>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">EmployeeId</label>
				<div class="col-md-4">
					<input name="EmployeeId" placeholder="EmployeeId"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">First
					Name</label>
				<div class="col-md-4">
					<input id="FirstName" name="FirstName"
						placeholder="Employee First Name" class="form-control input-md"
						required="" type="text"> <span class="help-block">
					</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Last
					Name</label>
				<div class="col-md-4">
					<input name="LastName" placeholder="Employee Last Name"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Gender</label>
				<div class="col-md-4">
					<input name="Gender" placeholder="Gender"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">BirthDate
				<div class="col-md-4">
					<input name="BirthDate" placeholder="BirthDate(yyyy-MM-dd)"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">HireDate</label>
				<div class="col-md-4">
					<input name="HireDate" placeholder="HireDate"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>
<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Salary</label>
				<div class="col-md-4">
					<input id="Salary" name="Salary" placeholder="Salary"
						class="form-control input-md" required="" type="text"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<input type="submit" value="Add" name="Add" ></button> 
					<input	type="submit" value="Update" name="Update">
				</div>
			</div>

		</fieldset>
	</form>
</body>
</html>