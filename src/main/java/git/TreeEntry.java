package git;

import java.io.DataOutputStream;
import java.io.IOException;

public record TreeEntry(
	TreeEntryMode mode,
	String name,
	byte[] hash
) {

	public void serialize(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.write(mode.format().getBytes());
		dataOutputStream.write(' ');
		dataOutputStream.write(name.getBytes());
		dataOutputStream.write('\0');
		dataOutputStream.write(hash);
	}

}