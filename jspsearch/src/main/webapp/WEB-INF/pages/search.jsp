<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    body{
        background: url("../../images/donuts.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
    .container{
        position: absolute;
        top: 15%;
        left: 60%;
    }
    .container h1{
        color: pink;
        width: 51%;
        display: inline-block;
        font-size: 40px;
        border-bottom: 5px solid pink;
        margin-bottom: 15px;
        padding: 13px 0;
    }
    .input{
    background: none;
    height: 29px;
        border: none;
        outline:none;
        color: pink;
        width: 109%;
        margin: 22px 0px;
       /* border-bottom: 5px solid pink;*/
        font-size: 28px;

    }
    .btn{
        color: white;
        cursor: pointer;
        outline: none;
        margin: 12px 0;
        padding: 10px 21px;
        border: 2px solid pink;
        border-radius: 10px;
        font-size: 18px;
        background: none;
        font-weight: bold;
    }
    .box{
        width: 100%;
        margin: 22px 0px;
        border-bottom: 2px solid pink;
    }
    .btn:hover{
        background-color:pink;
        color: white;
    }

</style>

<body>


<form action="process_search" , method="post">
<div class="container">
    <h1>Welcome</h1>
    <div class="box">
    <input class="input" name="name" type="text" placeholder="Please enter your name">
    </div>
    <div class="box">
    <input class="input" name="query" type="text" placeholder="What would you like to search">
    </div>
    <div>
        <button class="btn"> Search </button>
    </div>
</div>
</form>
</body>
</html>