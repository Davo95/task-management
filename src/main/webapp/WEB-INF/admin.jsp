<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <!-- Design by foolishdeveloper.com -->--%>
<%--    <title>Glassmorphism login Form Tutorial in html css</title>--%>

<%--    <link rel="preconnect" href="https://fonts.gstatic.com">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">--%>
<%--    <link href="image\Task_logo.png" rel="icon">--%>
<%--    <!--Stylesheet-->--%>
<%--    <style media="screen">--%>
<%--        *,--%>
<%--        *:before,--%>
<%--        *:after{--%>
<%--            padding: 0;--%>
<%--            margin: 0;--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>
<%--        body{--%>
<%--            background-color: #080710;--%>
<%--        }--%>
<%--        .background{--%>
<%--            width: 430px;--%>
<%--            height: 520px;--%>
<%--            position: absolute;--%>
<%--            transform: translate(-50%,-50%);--%>
<%--            left: 50%;--%>
<%--            top: 50%;--%>
<%--        }--%>
<%--        .background .shape{--%>
<%--            height: 200px;--%>
<%--            width: 200px;--%>
<%--            position: absolute;--%>
<%--            border-radius: 50%;--%>
<%--        }--%>
<%--        .shape:first-child{--%>
<%--            background: linear-gradient(--%>
<%--                    #1845ad,--%>
<%--                    #23a2f6--%>
<%--            );--%>
<%--            left: -80px;--%>
<%--            top: -80px;--%>
<%--        }--%>
<%--        .shape:last-child{--%>
<%--            background: linear-gradient(--%>
<%--                    to right,--%>
<%--                    #ff512f,--%>
<%--                    #f09819--%>
<%--            );--%>
<%--            right: -30px;--%>
<%--            bottom: -80px;--%>
<%--        }--%>
<%--        form{--%>
<%--            width: 400px;--%>
<%--            background-color: rgba(255,255,255,0.13);--%>
<%--            position: absolute;--%>
<%--            transform: translate(-50%,-50%);--%>
<%--            top: 50%;--%>
<%--            left: 50%;--%>
<%--            border-radius: 10px;--%>
<%--            backdrop-filter: blur(10px);--%>
<%--            border: 2px solid rgba(255,255,255,0.1);--%>
<%--            box-shadow: 0 0 40px rgba(8,7,16,0.6);--%>
<%--            padding: 50px 35px;--%>
<%--        }--%>
<%--        form *{--%>
<%--            font-family: 'Poppins',sans-serif;--%>
<%--            color: #ffffff;--%>
<%--            letter-spacing: 0.5px;--%>
<%--            outline: none;--%>
<%--            border: none;--%>
<%--        }--%>
<%--        form h3{--%>
<%--            font-size: 32px;--%>
<%--            font-weight: 500;--%>
<%--            line-height: 42px;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        label{--%>
<%--            display: block;--%>
<%--            margin-top: 30px;--%>
<%--            font-size: 16px;--%>
<%--            font-weight: 500;--%>
<%--        }--%>
<%--        input{--%>
<%--            display: block;--%>
<%--            height: 50px;--%>
<%--            width: 100%;--%>
<%--            background-color: rgba(255,255,255,0.07);--%>
<%--            border-radius: 3px;--%>
<%--            padding: 0 10px;--%>
<%--            margin-top: 8px;--%>
<%--            font-size: 14px;--%>
<%--            font-weight: 300;--%>
<%--        }--%>
<%--        ::placeholder{--%>
<%--            color: #e5e5e5;--%>
<%--        }--%>
<%--        button{--%>
<%--            margin-top: 50px;--%>
<%--            width: 100%;--%>
<%--            background-color: #ffffff;--%>
<%--            color: #080710;--%>
<%--            padding: 15px 0;--%>
<%--            font-size: 18px;--%>
<%--            font-weight: 600;--%>
<%--            border-radius: 5px;--%>
<%--            cursor: pointer;--%>
<%--        }--%>
<%--        .social{--%>
<%--            margin-top: 30px;--%>
<%--            display: flex;--%>
<%--        }--%>
<%--        .social div{--%>
<%--            background: red;--%>
<%--            width: 150px;--%>
<%--            border-radius: 3px;--%>
<%--            padding: 5px 10px 10px 5px;--%>
<%--            background-color: rgba(255,255,255,0.27);--%>
<%--            color: #eaf0fb;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        .social div:hover{--%>
<%--            background-color: rgba(255,255,255,0.47);--%>
<%--        }--%>
<%--        .social .fb{--%>
<%--            margin-left: 25px;--%>
<%--        }--%>
<%--        .social i{--%>
<%--            margin-right: 4px;--%>
<%--        }--%>

<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="background">--%>
<%--    <div class="shape"></div>--%>
<%--    <div class="shape"></div>--%>
<%--</div>--%>

<%--<form>--%>
<%--    <h3><a href="/home">Home</a> </h3>--%>
<%--    <h3><a href="/addUser">Add User</a></h3>--%>
<%--    <h3><a href="/addTask">Add Task</a> </h3>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page import="am.itspace.taskmanagement.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.taskmanagement.model.User" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Task Management</title>
    <link href="image\Task_logo.png" rel="icon">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #404E67;
            background: #F5F7FA;
            font-family: 'Open Sans', sans-serif;
        }

        .table-wrapper {
            width: 100%;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 10px;
            margin: 0 0 10px;
        }

        .table-title h2 {
            margin: 6px 0 0;
            font-size: 22px;
        }

        .table-title .add-new {
            float: right;
            height: 30px;
            font-weight: bold;
            font-size: 12px;
            text-shadow: none;
            min-width: 100px;
            border-radius: 50px;
            line-height: 13px;
        }

        .table-title .add-new i {
            margin-right: 4px;
        }

        table.table {
            table-layout: fixed;
        }

        table.table tr th,
        table.table tr td {
            border-color: #e9e9e9;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table th:last-child {
            width: 100px;
        }

        table.table td a {
            cursor: pointer;
            display: inline-block;
            margin: 0 5px;
            min-width: 24px;
        }

        table.table td a.add {
            color: #27C46B;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #E34724;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table td a.add i {
            font-size: 24px;
            margin-right: -1px;
            position: relative;
            top: 3px;
        }

        table.table .form-control {
            height: 32px;
            line-height: 32px;
            box-shadow: none;
            border-radius: 2px;
        }

        table.table .form-control.error {
            border-color: #f50000;
        }

        table.table td .add {
            display: none;
        }
    </style>
</head>

<body>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<% List<Task> tasks = (List<Task>) request.getAttribute("tasks"); %>
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <h2>User <b>Management</b></h2>
                    </div>
                    <div class="col-sm-4">
                        <button class="btn btn-info add-new"><i class="fa fa-plus"></i>
                            <a href="/logout" style="color: white">Logout</a></button>
                        <button class="btn btn-info add-new"><i class="fa fa-plus"></i>
                            <a href="/addUser" style="color: white">Add User</a></button>

                    </div>
                </div>
            </div>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Email</th>
                    <th>User Type</th>
                    <th>Delete</th>
                </tr>
                <% if (users != null && !users.isEmpty()) {
                    for (User user : users) {
                %>
                <tr>
                    <td><%=user.getName()%>
                    </td>
                    <td><%=user.getSurname()%>
                    </td>
                    <td><%=user.getEmail()%>
                    </td>
                    <td><%=user.getUserType()%>
                    </td>
                    <td><a class="delete" title="Delete" data-toggle="tooltip" href="/deleteUser?id=<%=user.getId()%>"><i
                            class="material-icons">&#xE872;</i></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </thead>
            </table>
        </div>
    </div>
</div>
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <h2>Task <b>Management</b></h2>
                    </div>
                    <div class="col-sm-4">
                        <button class="btn btn-info add-new"><i class="fa fa-plus"></i>
                            <a href="/addTask" style="color: white">Add Task</a></button>

                    </div>
                </div>
            </div>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>deadline</th>
                    <th>status</th>
                    <th>User name</th>
                    <th>User surname</th>
                    <th>Delete</th>
                </tr>
                <% if (tasks != null && !tasks.isEmpty()) {
                    for (Task task : tasks) {
                %>
                <tr>
                    <td><%=task.getName()%>
                    </td>
                    <td><%=task.getDescription()%>
                    </td>
                    <td><%=task.getDeadline()%>
                    </td>
                    <td><%=task.getStatus()%>
                    </td>
                    <td><%=task.getUserId().getName()%>
                    </td>
                    <td><%=task.getUserId().getSurname()%>
                    </td>
                    <td>
                        <a class="edit" title="Update" data-toggle="tooltip" href="/updateTask?id=<%=task.getId()%>"><i
                                class="material-icons">&#xE254;</i></a>
                        <a class="delete" title="Delete" data-toggle="tooltip" href="/deleteTask?id=<%=task.getId()%>"><i
                                class="material-icons">&#xE872;</i></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>

</html>
