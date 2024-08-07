/**MIT License

Copyright (c) 2024 Samyak Kamble

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.samyak2403.lovecalculator.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.samyak2403.lovecalculator.R
import com.samyak2403.lovecalculator.databinding.FragmentLoveBinding

import com.samyak2403.lovecalculator.ui.viewmodel.LoveViewModel
import com.samyak2403.lovecalculator.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveFragment : Fragment(R.layout.fragment_love) {

    val binding by viewBinding(FragmentLoveBinding::bind)
    private val viewModel: LoveViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI(){

        viewModel.response.observe(viewLifecycleOwner, {

            when (it?.percentage) {
                null -> {
                    // nothing
                }
                "Error" -> {
                    Toast.makeText(context, "Sorry.. try again later :(", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //
                    val bundle = bundleOf(
                        "firstName" to binding.myName.text.toString().trim(),
                        "secondName" to binding.partnerName.text.toString().trim(),
                        "percentage" to it.percentage,
                        "result" to it.result
                    )

                    findNavController().navigate(R.id.action_loveFragment_to_resultFragment, bundle)
                    viewModel.response.postValue(null)

                }
            }
            binding.loaderLayout.visibility = View.GONE
        })

        binding.checkBtn.setOnClickListener {
            performCheck()
        }
        binding.clearText.setOnClickListener {
            binding.myName.text.clear()
        }
        binding.clearText2.setOnClickListener {
            binding.partnerName.text.clear()
        }

        binding.apiLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://rapidapi.com/ajith/api/love-calculator/")))
        }
        binding.repositoryLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samyak2403")))
        }
    }

    private fun performCheck(){

        if (binding.myName.text.toString().trim().length>=2 && binding.partnerName.text.toString().trim().length>=2){

                binding.loaderLayout.visibility = View.VISIBLE

                viewModel.getPercentage(
                    binding.myName.text.toString().trim(),
                    binding.partnerName.text.toString().trim()
                )
            }else{
                Toast.makeText(context, "Please enter valid names !", Toast.LENGTH_SHORT).show()
            }

    }

  
}
