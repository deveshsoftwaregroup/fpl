<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="<%=request.getContextPath()%>" />
	<c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %>  
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <title>The 12th Man Fantasy League</title>
     <style>
         #paymentModel table tr th, #paymentModel table tr td , {color:#000 !important;}
         th , td{color:#000 !important;}
         .form-control, select {color:#000 !important;}
         thead  {background-color: #ff5733;}
       </style> 
   </head>
   <body class="fantasy-bg leadership">
      <div class="container ">
      
      <div class="row">
        
         <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 leader-board">

           <img src="${context}/redBlackTheme/images/leaderboard-bnr.png" class="img-responsive pddn_30">
            <ul class="nav nav-tabs marg_top">
                <li class="active"><a data-toggle="tab" href="#home">All</a></li>
                <li><a data-toggle="tab" href="#menu1">Country </a></li>
                <li><a data-toggle="tab" href="#menu2">Fav Club</a></li>
                <li><a data-toggle="tab" href="#menu3">Local Club</a></li>
              </ul>
            
              <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                  
                    <table id="example" class="display" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>cost</th>
                                <th></th>
                                <th>Sel</th>
                                <th></th>
                                <th>Pts</th>
                                
                                
                            </tr>
                        </thead>
                       
                        <tbody>
                            <tr>
                                <td>Ederson</td>
                                <td>50m</td>
                                <td></td>
                                <td>48.6%</td>
                                <td></td>
                                <td>95</td>
                            </tr>
                            <tr>
                                <td>Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>28.6%</td>
                                <td></td>
                                <td>92</td>
                            </tr>
                            <tr>
                                <td> Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>37%</td>
                                <td></td>
                                <td>91</td>
                            </tr>
                            <tr>
                                <td> Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>48.6%</td>
                                <td></td>
                                <td>90</td>
                            </tr>
                            <tr>
                                <td>Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>23%</td>
                                <td></td>
                                <td>89</td>
                            </tr>
                            <tr>
                                <td>Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>45.5%</td>
                                <td></td>
                                <td>82</td>
                            </tr>
                            <tr>
                                <td>Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>48.6%</td>
                                <td></td>
                                <td>81</td>
                            </tr>
                            <tr>
                                <td>Lloris</td>
                                <td>50m</td>
                                <td></td>
                                <td>48.6%</td>
                                <td></td>
                                <td>75</td>
                            </tr>
                            <tr>
                                <td>Ederson</td>
                                <td>50m</td>
                                <td></td>
                                <td>48.6%</td>
                                <td></td>
                                <td>75</td>
                            </tr>
                            <tr>
                                <td>Ederson</td>
                                <td>50m</td>
                                <td></td>
                                <td>23%</td>
                                <td></td>
                                <td>73</td>
                            </tr>
                            <tr>
                                <td>Ederson/td>
                                <td>50m</td>
                                <td></td>
                                <td>30%</td>
                                <td></td>
                                <td>71</td>
                            </tr>
                            <tr>
                                <td>Ederson</td>
                                <td>50m</td>
                                <td></td>
                                <td>22%</td>
                                <td></td>
                                <td>71</td>
                            </tr>
                            <tr>
                                <td>Charde Marshall</td>
                                <td>50m</td>
                                <td></td>
                                <td>36%</td>
                                <td></td>
                                <td>71</td>
                            </tr>
                            <tr>
                                <td>Haley Kennedy</td>
                                <td>50m</td>
                                <td></td>
                                <td>43%</td>
                                <td></td>
                                <td>69</td>
                            </tr>
                            <tr>
                                <td>Tatyana Fitzpatrick</td>
                                <td>50m</td>
                                <td></td>
                                <td>19%</td>
                                <td></td>
                                <td>68</td>
                            </tr>
                            <tr>
                                <td>Michael Silva</td>
                                <td>50m</td>
                                <td></td>
                                <td>66%</td>
                                <td></td>
                                <td>68</td>
                            </tr>
                            <tr>
                                <td>Paul Byrd</td>
                                <td>50m</td>
                                <td></td>
                                <td>64%</td>
                                <td></td>
                                <td>54</td>
                            </tr>
                            <tr>
                                <td>Gloria Little</td>
                                <td>50m</td>
                                <td></td>
                                <td>59%</td>
                                <td></td>
                                <td>25</td>
                            </tr>
                            <tr>
                                <td>Bradley Greer</td>
                                <td>50m</td>
                                <td></td>
                                <td>41%</td>
                                <td></td>
                                <td>68</td>
                            </tr>
                            <tr>
                                <td>Dai Rios</td>
                                <td>50m</td>
                                <td></td>
                                <td>35%</td>
                                <td></td>
                                <td>98</td>
                            </tr>
                            <tr>
                                <td>Jenette Caldwell</td>
                                <td>50m</td>
                                <td></td>
                                <td>30%</td>
                                <td></td>
                                <td>55</td>
                            </tr>
                            <tr>
                                <td>Yuri Berry</td>
                                <td>50m</td>
                                <td></td>
                                <td>40%</td>
                                <td></td>
                                <td>56</td>
                            </tr>
                           
                           
                           
                        </tbody>
                    </table>

                </div>
                <div id="menu1" class="tab-pane fade">
                    
                      <table id="example1" class="display" cellspacing="0" width="100%">
                          <thead>
                              <tr>
                                  <th>Name</th>
                                  <th>cost</th>
                                  <th></th>
                                  <th>Sel</th>
                                  <th></th>
                                  <th>Pts</th>
                                  
                                  
                              </tr>
                          </thead>
                         
                          <tbody>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>95</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>28.6%</td>
                                  <td></td>
                                  <td>92</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>37%</td>
                                  <td></td>
                                  <td>91</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>90</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>89</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>45.5%</td>
                                  <td></td>
                                  <td>82</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>81</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>73</td>
                              </tr>
                              <tr>
                                  <td>Ederson/td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>22%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Charde Marshall</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>36%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Haley Kennedy</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>43%</td>
                                  <td></td>
                                  <td>69</td>
                              </tr>
                              <tr>
                                  <td>Tatyana Fitzpatrick</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>19%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>sdfsgsdg</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>66%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Paul Byrd</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>64%</td>
                                  <td></td>
                                  <td>54</td>
                              </tr>
                              <tr>
                                  <td>Gloria Little</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>59%</td>
                                  <td></td>
                                  <td>25</td>
                              </tr>
                              <tr>
                                  <td>Bradley Greer</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>41%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Dai Rios</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>35%</td>
                                  <td></td>
                                  <td>98</td>
                              </tr>
                              <tr>
                                  <td>Jenette Caldwell</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>55</td>
                              </tr>
                              <tr>
                                  <td>Yuri Berry</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>40%</td>
                                  <td></td>
                                  <td>56</td>
                              </tr>
                             
                             
                             
                          </tbody>
                      </table>
  
                  </div>
                  <div id="menu2" class="tab-pane fade">
                    
                      <table id="example2" class="display" cellspacing="0" width="100%">
                          <thead>
                              <tr>
                                  <th>Name</th>
                                  <th>cost</th>
                                  <th></th>
                                  <th>Sel</th>
                                  <th></th>
                                  <th>Pts</th>
                                  
                                  
                              </tr>
                          </thead>
                         
                          <tbody>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>95</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>28.6%</td>
                                  <td></td>
                                  <td>92</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>37%</td>
                                  <td></td>
                                  <td>91</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>90</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>89</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>45.5%</td>
                                  <td></td>
                                  <td>82</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>81</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>73</td>
                              </tr>
                              <tr>
                                  <td>Ederson/td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>22%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Charde Marshall</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>36%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Haley Kennedy</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>43%</td>
                                  <td></td>
                                  <td>69</td>
                              </tr>
                              <tr>
                                  <td>Tatyana Fitzpatrick</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>19%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>sdfsgsdg</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>66%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Paul Byrd</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>64%</td>
                                  <td></td>
                                  <td>54</td>
                              </tr>
                              <tr>
                                  <td>Gloria Little</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>59%</td>
                                  <td></td>
                                  <td>25</td>
                              </tr>
                              <tr>
                                  <td>Bradley Greer</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>41%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Dai Rios</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>35%</td>
                                  <td></td>
                                  <td>98</td>
                              </tr>
                              <tr>
                                  <td>Jenette Caldwell</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>55</td>
                              </tr>
                              <tr>
                                  <td>Yuri Berry</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>40%</td>
                                  <td></td>
                                  <td>56</td>
                              </tr>
                             
                             
                             
                          </tbody>
                      </table>
  
                  </div>
                  <div id="menu3" class="tab-pane fade">
                    
                      <table id="example3" class="display" cellspacing="0" width="100%">
                          <thead>
                              <tr>
                                  <th>Name</th>
                                  <th>cost</th>
                                  <th></th>
                                  <th>Sel</th>
                                  <th></th>
                                  <th>Pts</th>
                                  
                                  
                              </tr>
                          </thead>
                         
                          <tbody>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>95</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>28.6%</td>
                                  <td></td>
                                  <td>92</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>37%</td>
                                  <td></td>
                                  <td>91</td>
                              </tr>
                              <tr>
                                  <td> Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>90</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>89</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>45.5%</td>
                                  <td></td>
                                  <td>82</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>81</td>
                              </tr>
                              <tr>
                                  <td>Lloris</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>48.6%</td>
                                  <td></td>
                                  <td>75</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>23%</td>
                                  <td></td>
                                  <td>73</td>
                              </tr>
                              <tr>
                                  <td>Ederson/td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Ederson</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>22%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Charde Marshall</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>36%</td>
                                  <td></td>
                                  <td>71</td>
                              </tr>
                              <tr>
                                  <td>Haley Kennedy</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>43%</td>
                                  <td></td>
                                  <td>69</td>
                              </tr>
                              <tr>
                                  <td>Tatyana Fitzpatrick</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>19%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>sdfsgsdg</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>66%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Paul Byrd</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>64%</td>
                                  <td></td>
                                  <td>54</td>
                              </tr>
                              <tr>
                                  <td>Gloria Little</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>59%</td>
                                  <td></td>
                                  <td>25</td>
                              </tr>
                              <tr>
                                  <td>Bradley Greer</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>41%</td>
                                  <td></td>
                                  <td>68</td>
                              </tr>
                              <tr>
                                  <td>Dai Rios</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>35%</td>
                                  <td></td>
                                  <td>98</td>
                              </tr>
                              <tr>
                                  <td>Jenette Caldwell</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>30%</td>
                                  <td></td>
                                  <td>55</td>
                              </tr>
                              <tr>
                                  <td>Yuri Berry</td>
                                  <td>50m</td>
                                  <td></td>
                                  <td>40%</td>
                                  <td></td>
                                  <td>56</td>
                              </tr>
                             
                             
                             
                          </tbody>
                      </table>
  
                  </div>
              </div>
            
         </div>
         
      </div>
      </div>
     
          
         
          
         
          

    <script>
        $(document).ready(function() {
            $('#example').DataTable( {
                "order": [[ 3, "desc" ]]
            } );

            $('#example1').DataTable( {
                "order": [[ 3, "desc" ]]
            } );
            $('#example2').DataTable( {
                "order": [[ 3, "desc" ]]
            } );
            $('#example3').DataTable( {
                "order": [[ 3, "desc" ]]
            } );
        } );
    </script>
   
  

    

   </body>
</html>