const http = require('http');

http.createServer( (request, response) => {
   response.writeHead(200, {'Content-Type': 'text/plain'});
   response.write('Hello World');
   response.end();
}).listen(8000);

console.log("Server started.  Listening for requests on port 8000.");