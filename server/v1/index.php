<?php
 
require '../libs/Slim/Slim.php';

define('RESPONSE_SUCCESS', 0);
define('RESPONSE_SUCCESS_NO_DATA', 1);
define('RESPONSE_ERROR', 2);


\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

// User id from db - Global Variable
$user_id = NULL;
/**
 * Echoing json response to client
 * @param String $status_code Http response code
 * @param Int $response Json response
 */
function echoRespnse($status_code,$status, $data) {
	$app = \Slim\Slim::getInstance();
	// Http response code
	$app->status($status_code);

	// setting response content type to json
	$app->contentType('application/json');
	
	$response = array();

	if($status == RESPONSE_SUCCESS){
		$response["status"] = "success";
		$response["data"] = $data;
	} else if($status == RESPONSE_ERROR) {
		$response["status"] = "error";
		$response["message"] = $data;
	} else if($status == RESPONSE_SUCCESS_NO_DATA){
		$response["status"] = "success";
		$response["message"] = $data;
	}
	echo json_encode($response);
}

function xml2array($xml){

                $inputs = array();
                $count = 0;
                foreach($xml as $element) {
                        $current = array();
                        $count++;
                        #print_r($element);
                        foreach ($element as $attribute=>$node) {
                                $current[$attribute] = $node->__toString();
                        }
                        array_push($inputs,$current);
                }
                return $inputs;
}




$app->post('/categories',function() use ($app){
	
	$xml=simplexml_load_file("files/categories.xml") or die("Error: Cannot create object");
	
	$response = array();
	$cats = xml2array($xml);

	$response['categories']	 = $cats;
	echoRespnse(200, RESPONSE_SUCCESS, $response);
});

$app->get('/files',function() use ($app){
	
	$xml=simplexml_load_file("files/categories.xml") or die("Error: Cannot create object");
	
	$response = array();
	$cats = xml2array($xml);

	$response['categories']	 = $cats;
	echoRespnse(200, RESPONSE_SUCCESS, $response);
});


function verifyRequiredParams($required_fields) {
        $error = false;
        $error_fields = "";
        $request_params = array();
        $request_params = $_REQUEST;
        // Handling PUT request params
        if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
                $app = \Slim\Slim::getInstance();
                parse_str($app->request()->getBody(), $request_params);
        }
        foreach ($required_fields as $field) {
                if (!isset($request_params[$field]) || strlen(trim($request_params[$field])) <= 0) {
                        $error = true;
                        $error_fields .= $field . ', ';
                }
        }

        if ($error) {
                // Required field(s) are missing or empty
                // echo error json and stop the app
                $app = \Slim\Slim::getInstance();
                $message= 'Required field(s) ' . substr($error_fields, 0, -2) . ' is missing or empty';
                echoRespnse(400, RESPONSE_ERROR, $message);
                $app->stop();
        }
}

$app->post('/coursesi2',function() use ($app){
	
	verifyRequiredParams(array('category_id'));

	$cat_id = $app->request->post('category_id');

	$xml=simplexml_load_file("files/categories.xml") or die("Error: Cannot create object");
	
	$response = array();
	$cats = xml2array($xml);


	foreach ($cats as $cat) {
		if ($cat['id'] == $cat_id){
			$course_file = $cat['url'];
			continue;
		}
	}

	$xml2 = simplexml_load_file("files/".$course_file) or die("Error: Cannot create object");
	#$courses = xml2array($xml2);
	$json = json_encode($xml2);
	$courses = json_decode($json,TRUE);

	$response['courses']= $courses;
	echoRespnse(200, RESPONSE_SUCCESS, $response);
});


$app->post('/courses',function() use ($app){
	


	$xml=simplexml_load_file("files/categories.xml") or die("Error: Cannot create object");
	
	$response = array();
	$cats = xml2array($xml);

	$courses = array();
	foreach ($cats as $cat) {
		$xml2 = simplexml_load_file("files/".$cat['url']) or die("Error: Cannot create object");
		#$courses = xml2array($xml2);
		$json = json_encode($xml2);
		$course = json_decode($json,TRUE);
		array_push($courses, $course);
	}


	$response['courses']= $courses;
	echoRespnse(200, RESPONSE_SUCCESS, $response);
});



$app->run();

?>
