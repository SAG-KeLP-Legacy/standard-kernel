standard-kernel
=========

 [**KeLP**][kelp-site] is the Kernel-based Learning Platform developed in the [Semantic Analytics Group][sag-site] ofs
the [University of Roma Tor Vergata][uniroma2-site]. 

This is the standard-kernel module of KeLP. It includes some of the most common kernels described in (Shawe-Taylor '04):

**DIRECT KERNELS:**

* _LinearKernel_: it performs a dot product between explicit feature vectors, like _DenseVector_ or _SparseVector_.

**KERNEL COMPOSITIONS:**

* _PolynomialKernel_: it applies the polynomial operation over the result of another kernel
* _RbfKernel_: it is the implementations of the Radial Basis Funtion Kernel (a.k.a. Gaussian Kernel)
* _NormalizationKernel_: it normalizes the result of another kernel making it ranging in [-1;1]

**KERNEL COMBINATIONS:**

* _LinearKernelCombination_: it applies a weighted linear combination of kernels 

**KERNEL OVER PAIRS:**

* _PreferenceKernel_: it is the implementation of the Preference Kernel proposed in (Shen '03) and largely used in lerning to rank tasks

============
REFERENCES:

(Shawe-Taylor '04) J. Shawe-Taylor and N. Cristianini. _Kernel Methods for Pattern Analysis_. Cambridge University Press, 2004.

(Shen '03) L. Shen and A. K. Joshi. _An SVM based voting algorithm with application to parse reranking_. In Proc. of CoNLL. 2003

[sag-site]: http://sag.art.uniroma2.it "SAG site"
[uniroma2-site]: http://www.uniroma2.it "University of Roma Tor Vergata"
[kelp-site]: http://sag.art.uniroma2.it/demo-software/kelp/