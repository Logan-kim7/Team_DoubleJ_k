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
  선정한 주제를
  위한 CSS공간*/

  #headline {
    text-align: center;
  }
  
  #headset {
    display: inline-block;
    width: 80%;
    height: auto;
    margin-top: 40px;
    border: 3px solid black;
    border-radius: 8px;
    text-align: center;
    font-weight: bold;
  }

  #headlegend {
    font-size: 20px;
    padding: 0px 30px;
  }

  #googletrand {
    font-size: 40px;
  }

  /*여기는
  선정한 주제를
  위한 CSS공간*/

  #listcustomers {
       font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
       border-collapse: collapse;
       width: 100%;
}

    #listcustomers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
}

    #listcustomers tr:nth-child(even){background-color: #f2f2f2;}

    #listcustomers tr:hover {background-color: #ddd;}

    #listcustomers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: gray ;
        color: white;
      }

      .pagination {
           display: inline-block;
           padding-top: 10px;
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

  /*여기는
  순위표와 입력창을
  위한 CSS공간*/
    
  #user_bord {
    text-align: center;
  }

  .cmlist {
    display: inline-block;
    text-align: center;
    width: 70%;
    height: 100%;
  }

  .cmlist h2 {
    font-size: 30px;
    margin-bottom: 20px;
  }

  #user_write {
    text-align: center;
  }

  #writeset {
    margin-top: 70px;
    display: inline-block;
    height: auto;
    width: 40%;
    border: 5px dotted black;
    border-radius: 8px;
    text-align: center;
  }

  #writelegend {
    text-align: center;
    font-size: 20px;
    font-weight: bold;
    padding: 0px 30px;
  }

  .inputbox {
    display: inline-block;
    width: 70%;
   	margin: 30px 0px;
  }

  .inputbox:nth-child(3) {
    margin-bottom: 60px;
  }

  #writebutton {
    text-align: center;
    padding: 50px 0px;
  }

  #throwit {
    background-color: gray;
    color: black;
    height: 50px;
    width: 160px;
    margin: 5px 10px 5px 0px;
    border-radius: 20px;
    font-weight: bold;
    border: 3px solid black;
    transition: all 0.5s;
    outline: none;
  }
  
  #addit {
    background-color: black;
    color: gray;
    height: 50px;
    width: 160px;
    margin: 5px 0px 5px 10px;
    border-radius: 20px;
    font-weight: bold;
    border: 3px solid gray;
    transition: all 0.5s;
    outline: none;
  }
  
  #throwit:hover {
    background-color: black;
    color: gray;
    border: 3px solid gray;
    margin: 0px 0px 0px 0px;
    width:  170px;
    height: 60px;
    transition: all 0.5s;
  }
  
  #addit:hover {
    background-color: gray;
    color: black;
    border: 3px solid black;
    margin: 0px 0px 0px 0px;
    width:  170px;
    height: 60px;
    transition: all 0.5s;
  }
  
  /*여기는
  순위표와 입력창을
  위한 CSS공간*/

  /*여기는 footer*/
  footer {
    height: 100px;
    text-align: center;
    background-color: black;
    color: white;
  }
  /*여기는 footer*/


</style>
</head>
<body>

      <div id="headline">
        <fieldset id="headset">
          <legend id="headlegend">선택한 주제</legend>
          	<p id="googletrand">호옹이!!</p>
        </fieldset>
      </div>

      <div id="user_write">
        <fieldset id="writeset">
          <legend id="writelegend">내가 작성하기</legend>
          
            <form class="inputbox">
                <label for="fname">4자성어를 입력하세요</label>
                <input type="text" id="fname" name="fname" placeholder="4글자만 입력가능!!!">
            </form>
            
            <form class="inputbox">
                <label for="fname">4자성어 설명을 입력하세요</label>
                <input type="text" id="fname" name="fname" placeholder="12글자까지만 입력가능!!!">
            </form>
            
        </fieldset>
      </div>

  <div id="writebutton">
    <button id="throwit" type="button"><p>영 아니다</p></button>
    <button id="addit" type="button"><p>잘만든것 같다</p></button>
  </div>


      <div id="user_bord">

        <div class="cmlist">
            
          <h2>4자성어 Drip Bag </h2>
       
        <table id="listcustomers">
          <tr>
            <th>작성자</th>
            <th>내용</th>
            <th>좋아요</th>
            <th>싫어요</th>
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
        </div>
      </div>
    </div>

</body>
</html>