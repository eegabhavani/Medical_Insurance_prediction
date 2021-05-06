package medical.ml;


import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


public class linear {
	public static void main(String[] args) throws Exception{
		DataSource source = new DataSource("C:\\Users\\DELL\\eclipse-workspace\\medical.ml\\src\\main\\java\\medical\\ml\\insurance.arff");
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		/**
		 * linear regression model
		 */
		LinearRegression lr = new LinearRegression();
		lr.buildClassifier(dataset);
		System.out.println(lr);
		Evaluation lreval = new Evaluation(dataset);
		System.out.println(lreval);
		lreval.evaluateModel(lr, dataset);
		System.out.println(lreval.toSummaryString());
		
		/**
		 * svm regression model
		 */
		SMOreg smoreg = new SMOreg();
		smoreg.buildClassifier(dataset);
		Evaluation svmregeval = new Evaluation(dataset);
		svmregeval.evaluateModel(smoreg, dataset);
		System.out.println(svmregeval.toSummaryString());
		
		

		
	}
}
