const express = require("express");

/* this is our application */
let app = express();
const port = 3000;

/* HTTP request logger middleware.
   'dev' - sends request to the 
   console - for debugging.
*/
const morgan = require("morgan");
app.use(morgan("dev"));

/*
What is app.use()

Express functionality is provided 
through middleware, which are 
functions that manipulate the request 
and response objects.

 Returns middleware that only parses 
 application/json encoded data.

 See and read this link: 
 https://medium.com/@adamzerner/how-bodyparser-works-247897a93b90
*/
const bodyParser = require("body-parser");
app.use(bodyParser.json());


/* You need to use bodyParser() if you want the 
   form data to be available in req.body. */
app.use(bodyParser.urlencoded({extended: false}));


/* Parse cookie header and populate 
req.cookies with an object keyed by 
the cookie names. */
const cookieParser = require("cookie-parser");
app.use(cookieParser());

app.get("/", (req, resp) => {
	 resp.setHeader('Access-Control-Allow-Origin', '*');
    resp.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE'); // If needed
    resp.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type'); // If needed
    resp.setHeader('Access-Control-Allow-Credentials', true); // If needed
    resp.status(200).json({message: 'Greetings Guest!', 
              authenticated: false});
});

app.listen(port, () =>{
    console.info(`Application Started.  Port: ${port}`)
});


