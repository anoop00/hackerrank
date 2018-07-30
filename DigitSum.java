import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class DigitSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);

		int weight = in.readInt();

		List<String[]> list = new ArrayList<>();

		for (int i = 1; i <= 12; i++) {
			// String l = in.readString();
			String s[] = new String[3];
			
			for (int j = 0; j < 3; j++)
				s[j] = in.readString();
			list.add(s);
		}
		int res = 0;

		
		int m = 0;
		int n = 0;
		int w=0;
		
		for (String ar[] : list) {
			
			if(Integer.parseInt(ar[0])>Integer.parseInt(ar[1])) {
				if(m<Integer.parseInt(ar[0]) && n<Integer.parseInt(ar[1])) {
					m=Integer.parseInt(ar[0]);
					n=Integer.parseInt(ar[1]);
					w = Integer.parseInt(ar[2]);
				} 				
				//System.out.println(m+"="+n);
			} else {
				if(m<Integer.parseInt(ar[1]) && n<Integer.parseInt(ar[0])) {
					m=Integer.parseInt(ar[1]);
					n=Integer.parseInt(ar[0]);
					w = Integer.parseInt(ar[2]);
				} 		
				//System.out.println(m+"="+n);
			}
		}
		
		int totalD=weight/w;
		
		
		if(totalD%2==0) {
			res = (m*(totalD/2+1))+(n*(totalD/2+1));
		} else {
			res = (m*(totalD/2+1))+(n*(totalD/2+1));
		}
		/*int sum=0;
		int c =0;*/
		//System.out.println(m+"="+n);
		
		/*while(sum!=weight) {
			if(c==0) {
				res+=m;
				if(sum<weight) {
					res+=n;
					sum+=w;
					c++;
				}
			} else {
				res+=m;
				sum+=w;
				if(sum<weight) {
					res+=n;
					sum+=w;
					c++;
				}
			}
			
			
		}*/
		
		
	/*	for (String ar[] : list) {
			int max = 0;
			int sum = 0;
			int c = 0;
			int f1 = 0;
			int f2 = 0;
			if (Integer.parseInt(ar[0]) > Integer.parseInt(ar[1])) {
				f1 = Integer.parseInt(ar[0]);
				f2 = Integer.parseInt(ar[1]);

				while (sum != weight) {
					if (c == 0) {
						c++;
						max += f1;
						if (sum < weight) {
							max += f2;
							sum += Integer.parseInt(ar[2]);
						}
					} else {
						max += f1;
						sum += Integer.parseInt(ar[2]);
						if (sum < weight) {
							max += f2;
							sum += Integer.parseInt(ar[2]);
						}
					}

				}
			} else {
				f1 = Integer.parseInt(ar[0]);
				f2 = Integer.parseInt(ar[1]);

				while (sum != weight) {

					if (c == 0) {
						c++;
						max += f2;
						if (sum < weight) {
							max += f1;
							sum += Integer.parseInt(ar[2]);
						}
					} else {
						max += f1;
						sum += Integer.parseInt(ar[2]);
						if (sum < weight) {
							max += f2;
							sum += Integer.parseInt(ar[2]);
						}
					}

				}

			}

			
			 * if (Integer.parseInt(ar[0]) > Integer.parseInt(ar[1])) { if (weight % 2 == 0)
			 * { int b = weight / Integer.parseInt(ar[2]); max = Integer.parseInt(ar[0]) *
			 * b/2 + Integer.parseInt(ar[1]) * b/2; } else { int b = weight /
			 * Integer.parseInt(ar[2]); max = Integer.parseInt(ar[0]) * b/2+1 +
			 * Integer.parseInt(ar[1]) * b/2; } } else { if (weight % 2 == 0) { int b =
			 * weight / Integer.parseInt(ar[2]); max = Integer.parseInt(ar[0]) * b/2 +
			 * Integer.parseInt(ar[1]) * b/2; } else { int b = weight /
			 * Integer.parseInt(ar[2])+1; max = Integer.parseInt(ar[1]) * b/2+1 +
			 * Integer.parseInt(ar[0]) * b/2; } }
			 
			if (res < max) {
				res = max;
			}
		}*/
		System.out.println(res);
	}

	private static void closeStreams(OutputWriter out, InputReader in) throws IOException {
		out.flush();
		out.close();
		in.close();
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			if (filter != null) {
				return filter.isEndOfLine(c);
			}
			return c == '\n' || c == '\r' || c == -1;
		}

		public String next() {
			return readString();
		}

		public void close() throws IOException {
			this.stream.close();
		}

		public interface SpaceCharFilter {
			boolean isSpaceChar(int ch);

			boolean isEndOfLine(int ch);
		}

	}

	static class IOUtils {

		public static int[] readIntArray(InputReader in, int elementCount) {
			return readIntArray(in, elementCount, 0);
		}

		public static int[] readIntArray(InputReader in, int elementCount, int startOffset) {
			int[] array = new int[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++)
				array[i + startOffset] = in.readInt();
			return array;
		}

		public static long[] readLongArray(InputReader in, int elementCount) {
			return readLongArray(in, elementCount, 0);
		}

		public static long[] readLongArray(InputReader in, int elementCount, int startOffset) {
			long[] array = new long[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++)
				array[i + startOffset] = in.readLong();
			return array;
		}

	}

	static class OutputWriter {

		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}

	}

}
