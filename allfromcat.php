<?php
 
/*
 * Following code will get all info about a course
 */
 
define('DB_USER', "a3986172_root"); // db user
define('DB_PASSWORD', "r00tuser"); // db password (mention your db password here)
define('DB_DATABASE', "a3986172_main"); // database name
define('DB_SERVER', "mysql6.000webhost.com"); // db server
 
class DB_CONNECT {
 
    // constructor
    function __construct() {
        // connecting to database
        $this->connect();
    }
 
    // destructor
    function __destruct() {
        // closing db connection
        $this->close();
    }
 
    /**
     * Function to connect with database
     */
    function connect() {
        // import database connection variables
 
        // Connecting to mysql database
        $con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());
 
        // Selecing database
        $db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());
 
        // returing connection cursor
        return $con;
    }
 
    /**
     * Function to close db connection
     */
    function close() {
        // closing db connection
        mysql_close();
    }
 
}
 
// array for JSON response
$response = array();
// connecting to db
$db = new DB_CONNECT();
 
// get all products from products table
$id = 'nothing';
if (isset($_GET['categoryId']))
{
     $id = $_GET['categoryId'];
}
$result = mysql_query("SELECT course_name FROM master WHERE category_id=$id") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["courses"] = array();

    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $course = array();
        $course["course_name"] = $row["course_name"];
 
        // push single product into final response array
        array_push($response["courses"], $course);
    }    
  
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No courses found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>	