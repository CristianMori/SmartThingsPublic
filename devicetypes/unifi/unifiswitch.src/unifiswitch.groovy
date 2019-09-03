/**
 *  test
 *
 *  Copyright 2019 Cristian Mori
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "UniFiSwitch", namespace: "Unifi", author: "Cristian Mori", cstHandler: true) {
		capability "Switch"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "parse"
	def msg = parseLanMessage(description)

    def headersAsString = msg.header // => headers as a string
    def headerMap = msg.headers      // => headers as a Map
    def body = msg.body              // => request body as a string
    def status = msg.status          // => http status code of the response
    def json = msg.json              // => any JSON included in response body, as a data structure of lists and maps
    def xml = msg.xml                // => any XML included in response body, as a document tree structure
    def data = msg.data              // => either JSON or XML in response body (whichever is specified by content-type header in response)
	log.debug "Parsing '${description}'"
	// TODO: handle 'switch' attribute

}


// handle commands
def on() {
	log.debug "UniFi Executing 'on' lolo"
	def result = new physicalgraph.device.HubAction(
    method: "GET",
    path: "/",
    headers: [
        HOST: "192.168.1.106"
    ])
    //query: [param1: "value1", param2: "value2"]
    //)
    log.debug result
	sendHubCommand(result)
    // TODO: handle 'on' command
}

def off() {
	log.debug "UniFi Executing 'off'"
	// TODO: handle 'off' command
}