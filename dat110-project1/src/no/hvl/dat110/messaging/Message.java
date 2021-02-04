package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; 
		
		//checking for length within boundary
		
		if(payload.length < MessageConfig.SEGMENTSIZE)
			this.payload = payload;
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte)payload.length;
		
		for(int i = 0; i < payload.length; i++) 
			encoded[i+1] = payload[i];

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		this.payload = new byte[received[0]];
		
		for(int i =0; i<received[0]; i++)
			payload[i] = received[i+1];
		
	}
}
