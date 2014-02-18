<?php
 
/*
 * Following code will create a new product table
 * All product details are read from HTTP Post Request
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
 
// check for required fields
if (isset($_POST['courseId']) && isset($_POST['rating'])) {
 
    $id = $_POST['courseId'];
    $rating = $_POST['rating'];
    $comment = none;

    if (isset($_POST['comment']))
    {
       $comment = $_POST['comment'];
    }
    
    // connecting to database
    $db = new DB_CONNECT();
 
    // mysql create a new table for the course
    $result = mysql_query("INSERT INTO $id(ratings, comments) VALUES ($rating, $comment)");
 
    // check if successful
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Product successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert 
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>		