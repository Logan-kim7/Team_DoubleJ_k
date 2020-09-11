<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.min.js%22%3E"></script>
    <script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
	  /*여기는
  명예의전당 테이블을
  위한 CSS공간 시작*/
  
  #fame_interface {
    text-align: center;
    height: 100%;
  }

  #fametable {
       font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
       border-collapse: collapse;
       width: 100%;
}

    #fametable td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
}

    #fametable tr:nth-child(even){background-color: #f2f2f2;}

    #fametable tr:hover {background-color: #ddd;}

    #fametable th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: gray ;
        color: white;
      }

      .pagination {
          display: inline-block;
          margin-top: 10px;
      }

      .pagination a {
        color: black;
        float: left;
        padding: 8px 16px;
        text-decoration: none;
      }

      .pagination a.active {
        background-color: gray;
        color: white;
        border-radius: 5px;
      }

      .pagination a:hover:not(.active) {
        background-color: darkgray;
        border-radius: 5px;
      }
      
      input {
        width: 100%;
      }   


      .famelist {
        display: inline-block;
        text-align: center;
        width: 70%;
        height: 100% auto;
        padding: 3% 0 10% 0;

      }

      .famelist h2 {
        font-size: 30px;
        padding: 20px 0px;
      }

      .famelist tr {
        height: 40px;
      }

      #serch {
        display: inline-block;
        position: absolute;
        width: 150px;
        height: 40px;
        margin-left: 350px;
      }

      #serch input {
        width: 100%;
        height: 100%;
        border-radius: 8px;
        outline: none;
      }

      
      /*여기는
      명예의전당 테이블을
      위한 CSS공간 끝*/
</style>

</head>
<body>

	      <section id="fame_interface">

        <div class="famelist">
          <h2>Hall of Best Dripper</h2>
       
        <table id="fametable">
          <tr>
            <th>랭킹</th>
            <th>작성자</th>
            <th>사자성어</th>
            <th>점수</th>
            <th>작성일</th>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          
        </table>
        
        <div class="pagination">
          <a href="#">&laquo;</a>
          <a href="#"class="active">1</a>
          <a href="#">2</a>
          <a href="#">3</a>
          <a href="#">4</a>
          <a href="#">5</a>
          <a href="#">6</a>
          <a href="#">&raquo;</a>

          <div id="serch"><input type="text" placeholder="검색할 사자성어"></div>
        </div>

        
      </div>
      </section>

</body>
</html>