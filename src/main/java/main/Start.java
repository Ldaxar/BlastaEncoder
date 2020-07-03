package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import encode.EncodedProtein;
import encode.Encoder;
import reader.BlastaProtein;
import reader.Reader;

public class Start {

	public static void main(String[] args) throws IOException {
		File f = new File("data");
		f.delete();
		f.mkdir();
		Reader r = new Reader();
		List<BlastaProtein> l = r.readBlastaFile("blast_80.fasta");
		Encoder encoder = new Encoder();
		List<EncodedProtein> ep = encoder.encodeProteins(l);
		System.out.println("Total length: "+ep.size());
		//printEncodedList(l);
		//printBlasta(l);
		List<EncodedProtein>[] data = sortProteins(ep, 8);
		data = createSets(data, 69);
		generateDataset(21, 8, data[0], "data/train.dataset");
		System.out.println("Total training length: "+data[0].size());
		generateDataset(21, 8, data[1], "data/validation.dataset");
		System.out.println("Total validation length: "+data[1].size());
		generateDataset(21, 8, data[2], "data/test.dataset");
		System.out.println("Total test length: "+data[2].size());
		System.out.println("Blasta size: "+l.size());
		
	}
	
	private static void generateDataset(int inputSize, int classNumber, List<EncodedProtein> proteins, String name) throws IOException {
		FileWriter f = new FileWriter(name) ;
		f.write(proteins.size()+"");
		f.write('\n');
		f.write(inputSize+" "+classNumber);
		for (EncodedProtein encodedProtein : proteins) {
			f.write('\n');
			f.write(encodedProtein.getName());
			f.write('\n');
			f.write(encodedProtein.getProteinLength()+"");
			f.write('\n');
			StringBuilder sb = new StringBuilder();
			for (String aa : encodedProtein.getEncodedChain()) {
				for (char c: aa.toCharArray()) {
					sb.append(c);
					sb.append(' ');
				}
			}
			f.write(sb.toString().trim());
			f.write('\n');
			f.write(encodedProtein.getScl()+"");
		}
		f.flush();
		f.close();
	}
	
	@SuppressWarnings("unchecked")
	private static List<EncodedProtein>[] sortProteins(List<EncodedProtein> proteins, int binsNum) {
		List<EncodedProtein>[] bins = new ArrayList[binsNum];
		
		for (int i=0;i<bins.length;i++) {
			bins[i] = new ArrayList<>();
		}
		for (EncodedProtein prot : proteins) {
			bins[Integer.parseInt(prot.getScl())-1].add(prot);
		}
		return bins;
	}
	
	
	@SuppressWarnings("unchecked")
	private static List<EncodedProtein>[] createSets(List<EncodedProtein>[] bins, long seed) {
		//0 training, 1 validation, 2 testing
		Random r = new Random(seed);
		List<EncodedProtein>[] sets = new ArrayList[3];
		for (int i=0; i<sets.length;i++) {
			sets[i] = new ArrayList<>();
		}
		for (List<EncodedProtein> list : bins) {
			Collections.shuffle(list, r);
			sets[0].addAll(list.subList(0, (int)(list.size()*0.8)));
			sets[1].addAll(list.subList((int)(list.size()*0.8), (int)(list.size()*0.9)));
			sets[2].addAll(list.subList((int)(list.size()*0.9), list.size()));
		}
		Collections.shuffle(sets[0], r);
		Collections.shuffle(sets[1], r);
		Collections.shuffle(sets[2], r);
		return sets;
		
	}

	private static void printEncodedList(List<BlastaProtein> rawList) {
		Encoder encoder = new Encoder();
		Long start = System.currentTimeMillis();
		List<EncodedProtein> ep = encoder.encodeProteins(rawList);
		Long end = System.currentTimeMillis();
		System.out.println("Length "+ ep.size());
		System.out.println("Time: "+(end-start)+" millis");
	}
	
	private static void printBlasta(List<BlastaProtein> l) {
		for (BlastaProtein blastaProtein : l) {
			System.out.println(blastaProtein);
		}
		System.out.println("Length "+l.size());

	}

}
