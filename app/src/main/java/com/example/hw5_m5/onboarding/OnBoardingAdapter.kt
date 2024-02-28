package com.example.hw5_m5.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.hw5_m5.databinding.ItemOnboardingBinding
import com.example.hw5_m5.loadImage
import com.example.hw5_m5.OnBoardingModel

class OnBoardingAdapter (private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){
    private val list = arrayListOf<OnBoardingModel>(
        OnBoardingModel("Have a good time", "You should take the time to help those who need you", "https://i.pinimg.com/236x/c0/2a/1f/c02a1fc7bef87079e6b92a0ce6fe355e.jpg"),
        OnBoardingModel("Cherishing love", "It is no longer possible for you to cherish love", "https://i.pinimg.com/236x/a0/f2/64/a0f264e3f16e07ffa3bbb0b15a730aa1.jpg"),
        OnBoardingModel("Have a breakup?", "We have the correction for you don't worry \n mayby someone is waiting for you!", "https://i.pinimg.com/236x/de/5a/5d/de5a5d0269d552f48208c78839cd4491.jpg"),
        OnBoardingModel("It's funs and many more!", "", "https://image.winudf.com/v2/image/Y29tLm5pa2hpbDJhZ3Jhd2FsLmxvdmVfY2FsY3VsYXRvcl9zY3JlZW5fNV8xNTI2NDgzNTEwXzAwNA/screen-5.jpg?fakeurl=1&type=.jpg")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int= list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoardingModel) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            btnGetStarted.isVisible = adapterPosition == list.lastIndex
            ivBoard.loadImage(onBoarding.image.toString())

            btnGetStarted.setOnClickListener {
                onClick()
            }
        }
    }
}