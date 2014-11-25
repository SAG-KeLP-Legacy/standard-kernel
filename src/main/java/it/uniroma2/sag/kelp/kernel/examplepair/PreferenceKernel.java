/*
 * Copyright 2014 Simone Filice and Giuseppe Castellucci and Danilo Croce and Roberto Basili
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.uniroma2.sag.kelp.kernel.examplepair;

import com.fasterxml.jackson.annotation.JsonTypeName;

import it.uniroma2.sag.kelp.data.example.Example;
import it.uniroma2.sag.kelp.data.example.ExamplePair;
import it.uniroma2.sag.kelp.kernel.Kernel;
import it.uniroma2.sag.kelp.kernel.KernelComposition;
/**
 * It is a kernel operating of ExamplePairs applying the following formula:<br>
 * 
 * \(Kp(<x_1, x_2>,<y_1,y_2>)= K(x_1, y_1) + K(x_2, y_2) - K(x_1, y_2) - K(x_2, y_1) \) <br>
 * where K is another kernel the preference kernel relies on. <br> 
 *
 * The preference kernel was firstly introduced in: 
 * [Shen and Joshi, 2003] L. Shen and A. K. Joshi. An SVM based voting algorithm
 * with application to parse reranking. In Proc. of CoNLL. 2003.
 * 
 * @author Simone Filice
 */
@JsonTypeName("preference")
public class PreferenceKernel extends KernelComposition{
			
	public PreferenceKernel(Kernel baseKernel){
		this.baseKernel=baseKernel;		
	}
	
	public PreferenceKernel(){
		
	}
	
	@Override
	protected float kernelComputation(Example exA, Example exB) {
		
		if(!(exA instanceof ExamplePair) || !(exB instanceof ExamplePair)){
			throw new java.lang.IllegalArgumentException("Invalid object: expected two ExamplePairs to compute PreferenceKernel");
		}
		
		ExamplePair pairA = (ExamplePair)exA;
		ExamplePair pairB = (ExamplePair)exB;
		Example exA1 = pairA.getLeftExample();
		Example exA2 = pairA.getRightExample();
		Example exB1 = pairB.getLeftExample();
		Example exB2 = pairB.getRightExample();	
		
		return this.baseKernel.innerProduct(exA1, exB1) + this.baseKernel.innerProduct(exA2, exB2) 
				- this.baseKernel.innerProduct(exA1, exB2) - this.baseKernel.innerProduct(exA2, exB1);
	}
}
